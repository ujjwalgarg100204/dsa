"""
Problem Creation Script

This script automates the creation of problem-solving environments for different programming languages.
It handles directory structure creation, file naming conventions, and template management for each
supported language.
"""

import logging
from dataclasses import dataclass
from typing import Dict
import re
from pathlib import Path
import abc
from string import ascii_lowercase

logging.basicConfig(
    level=logging.INFO, format="%(asctime)s - %(levelname)s - %(message)s"
)
logger = logging.getLogger(__name__)


@dataclass
class ProblemConfig:
    """Configuration for problem creation.

    Attributes:
        path: Problem path in the directory structure
        name: Name of the problem
        language: Programming language to use
    """

    path: str
    name: str
    language: str


class CaseFormatter:
    """Utility class for formatting strings into different naming conventions."""

    @staticmethod
    def to_snake_case(s: str) -> str:
        """Convert string to snake_case.

        Args:
            s: Input string

        Returns:
            String in snake_case format
        """
        s = re.sub(r"[\-\s]", "_", s)
        s = re.sub(r"[^\w\s_]", "", s)
        return s.lower()

    @staticmethod
    def to_pascal_case(s: str) -> str:
        """Convert string to PascalCase.

        Args:
            s: Input string

        Returns:
            String in PascalCase format
        """
        return "".join(word.capitalize() for word in re.split(r"[\-\s_]", s))


class LanguageHandler(abc.ABC):
    """Abstract base class for language-specific handlers."""

    def __init__(self, base_dir: Path, templates_dir: Path):
        """Initialize language handler.

        Args:
            base_dir: Project root directory
            templates_dir: Directory containing templates
        """
        self.base_dir = base_dir
        self.templates_dir = templates_dir

    def read_template(self, template_name: str) -> str:
        """Read template file content.

        Args:
            template_name: Name of the template file

        Returns:
            Template content as string

        Raises:
            FileNotFoundError: If template file doesn't exist
        """
        template_path = self.templates_dir / self.language_name / template_name
        if not template_path.exists():
            raise FileNotFoundError(f"Template not found: {template_path}")
        return template_path.read_text()

    @property
    @abc.abstractmethod
    def language_name(self) -> str:
        """Get language name."""
        pass

    @abc.abstractmethod
    def create_structure(self, config: ProblemConfig) -> None:
        """Create directory structure and files for the problem.

        Args:
            config: Problem configuration
        """
        pass

    def format_name(self, name: str) -> str:
        """Format name according to language conventions.

        Args:
            name: Problem name

        Returns:
            Formatted name
        """
        return name


class JavaHandler(LanguageHandler):
    """Handler for Java language setup."""

    @property
    def language_name(self) -> str:
        return "java"

    def format_name(self, name: str) -> str:
        return CaseFormatter.to_pascal_case(name)

    def create_package_name(self, path: str) -> str:
        return path.replace("/", ".")

    def create_structure(self, config: ProblemConfig) -> None:
        """Create Java project structure with main and test files."""

        formatted_name = self.format_name(config.name)
        problem_dir = (
            self.base_dir / "codes/java/src/main/java/com/gargujjwal" / config.path
        )
        test_dir = (
            self.base_dir / "codes/java/src/test/java/com/gargujjwal" / config.path
        )

        problem_dir.mkdir(parents=True, exist_ok=True)
        test_dir.mkdir(parents=True, exist_ok=True)

        solution_template = self.read_template("Solution.java.template")
        test_template = self.read_template("SolutionTest.java.template")

        with open(problem_dir / f"{formatted_name}.java", "w") as f:
            f.write(
                solution_template.format(
                    package_name=self.create_package_name(config.path),
                    class_name=formatted_name,
                )
            )

        with open(test_dir / f"{formatted_name}Test.java", "w") as f:
            f.write(
                test_template.format(
                    package_name=self.create_package_name(config.path),
                    class_name=formatted_name,
                )
            )


class RustHandler(LanguageHandler):
    """Handler for Rust language setup."""

    @property
    def language_name(self) -> str:
        return "rust"

    def format_name(self, name: str) -> str:
        return CaseFormatter.to_snake_case(name)

    def create_binary_name(self, path: str, name: str) -> str:
        """Create unique binary name for Rust project.

        Args:
            path: Problem path
            name: Problem name

        Returns:
            Binary name formatted according to Rust conventions
        """
        snake_case_name = self.format_name(name)
        components = [path.replace("/", "__"), snake_case_name]
        return "__".join(components).lower()

    def create_structure(self, config: ProblemConfig) -> None:
        """Create Rust project structure and update Cargo.toml."""

        formatted_prob_name = self.format_name(config.name)
        problem_dir = self.base_dir / "codes/rust/src/bin" / config.path
        problem_dir.mkdir(parents=True, exist_ok=True)

        binary_name = self.create_binary_name(config.path, config.name)
        solution_template = self.read_template("solution.rs.template")

        with open(problem_dir / f"{formatted_prob_name}.rs", "w") as f:
            f.write(solution_template)

        cargo_path = self.base_dir / "codes/rust/Cargo.toml"
        with open(cargo_path, "a") as f:
            f.write(
                f'\n[[bin]]\nname = "{binary_name}"\npath = "src/bin/{config.path}/{formatted_prob_name}.rs"\n'
            )


class PathProcessor:
    """Utility class for processing and normalizing paths."""

    @staticmethod
    def normalize_path(path: str) -> str:
        """Normalize path by converting numbers to letters and standardizing separators.

        Args:
            path: Input path

        Returns:
            Normalized path string
        """

        def num_to_letter(match: re.Match) -> str:
            return ascii_lowercase[int(match.group(0))]

        path_parts = path.split("/")
        processed_parts = []
        for part in path_parts:
            if part[0:2].isdigit():
                part = re.sub(r"^(\d+)", num_to_letter, part)
            processed_parts.append(part)

        return "/".join(processed_parts).replace("-", "_").replace(" ", "_")


class ProblemCreator:
    """Main class for problem creation workflow."""

    def __init__(self):
        """Initialize ProblemCreator with project directories."""
        self.script_dir = Path(__file__).parent
        self.project_root = self.script_dir.parent
        self.templates_dir = self.script_dir / "templates"

        self.handlers: Dict[str, type[LanguageHandler]] = {
            "java": JavaHandler,
            "rust": RustHandler,
        }

    def create_problem(self, config: ProblemConfig) -> None:
        """Create problem structure using appropriate language handler.

        Args:
            config: Problem configuration

        Raises:
            ValueError: If language is not supported
        """

        # normalize the path, ie convert 00 to aa type format
        normalized_path = PathProcessor.normalize_path(config.path)
        logger.info(f"Creating problem structure for: {normalized_path}/{config.name}")
        config.path = normalized_path

        if config.language not in self.handlers:
            raise ValueError(f"Unsupported language: {config.language}")

        handler_class = self.handlers[config.language]
        handler = handler_class(self.project_root, self.templates_dir)
        handler.create_structure(config)


def main():
    """Main entry point for the script."""
    creator = ProblemCreator()

    path = input("Enter problem path: ")
    name = input("Enter problem name: ")
    language = input("Enter language (java/rust): ").lower()

    if language not in ["java", "rust"]:
        logger.error("Invalid language selection. Must be 'java' or 'rust'")
        return

    config = ProblemConfig(path=path, name=name, language=language)
    creator.create_problem(config)


if __name__ == "__main__":
    main()
