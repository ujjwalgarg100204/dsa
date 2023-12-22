import com.ujjwal.annotations.CurrentlySolving;
import com.ujjwal.models.Problem;
import com.ujjwal.models.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestProblems {
    private static final Logger log = LoggerFactory.getLogger(TestProblems.class);

    @Test
    void test() throws InvocationTargetException, IllegalAccessException {
        Set<Class<? extends Problem>> problems = getAllProblemClasses();
        Iterable<Problem> currentlySolvingProblems = instantiateProblems(filterProblemByAnnotation(problems, CurrentlySolving.class));

        for (Problem problem : currentlySolvingProblems) {
            log.info("Testing problem: " + problem.getName());
            for (Method method : (List<Method>) problem.getImplementations()) {
                log.info("Testing method: " + method.getName());
                for (TestCase<?, ?> testCase : (List<TestCase<?, ?>>) problem.getTestCases()) {
                    Object result = method.invoke(problem, testCase.input());
                    Assertions.assertEquals(result, testCase.expected());
                    log.info("Test case passed: " + testCase.input() + " -> " + result);
                }
            }
        }
    }

    Set<Class<? extends Problem>> getAllProblemClasses() {
        Reflections reflections = new Reflections("com.ujjwal.solutions");

        //  find all classes annotated with @SolvingProblem
        return reflections.getSubTypesOf(Problem.class);
    }

    Iterable<Class<? extends Problem>> filterProblemByAnnotation(
            Iterable<Class<? extends Problem>> problems,
            Class<? extends Annotation> annotationCls
    ) {
        List<Class<? extends Problem>> filteredProblems = new ArrayList<>();

        for (Class<? extends Problem> problem : problems) {
            if (problem.isAnnotationPresent(annotationCls)) {
                filteredProblems.add(problem);
            }
        }

        return filteredProblems;
    }

    Iterable<Problem> instantiateProblems(Iterable<Class<? extends Problem>> problems) {
        List<Problem> problemInstances = new ArrayList<>();

        try {
            for (Class<? extends Problem> problem : problems) {
                Constructor<? extends Problem> constructor = problem.getConstructor();
                Problem problemInstance = constructor.newInstance();
                problemInstances.add(problemInstance);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return problemInstances;
    }
}
