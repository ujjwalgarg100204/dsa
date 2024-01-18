<a name="readme-top" id="readme-top"></a>

<!-- Project Shields -->
<div>
<p align="center">
  <a href="https://github.com/ujjwalgarg100204/dsa/network/members"
  >
    <img
      src="https://img.shields.io/github/forks/ujjwalgarg100204/dsa.svg?style=for-the-badge"
      alt="fork-shield"
    />
  </a>
  <a
    href="https://github.com/ujjwalgarg100204/dsa/blob/master/LICENSE.txt"
  >
    <img
      src="https://img.shields.io/github/license/ujjwalgarg100204/dsa.svg?style=for-the-badge"
      alt="license-shield"
    />
  </a>
  <a href=" https://github.com/ujjwalgarg100204/dsa/stargazers">
    <img
      src="https://img.shields.io/github/stars/ujjwalgarg100204/dsa.svg?style=for-the-badge"
      alt="star-shield"
    />
  </a>
  <a href="https://linkedin.com/in/ujjwal-garg-3a5639243">
    <img
      src="https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555"
      alt="linkedin-shield"
    />
  </a>
</p>

<br />

<h3 align="center">Data Structures & Algorithm</h3>

  <p align="center" aria-label="Short Description of the project">
See my data structures and algorithm problem history.
    <br />
    <a
      href="https://github.com/ujjwalgarg100204/dsa/issues"
      aria-label="Link to issues of github repo"
      >Request a Problem</a
    >
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
		 <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#author">Author</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
<h2>About The Project</h2>
Data Structures and Algorithms is very important for programmers. I was doing DSA prior to this project but I never kept
its records, this is my attempt to have all the solutions to the problems that I have done. This can be helpful for
other people as they can learn problem solving in different languages. I also tried to built some light framework for
testing to actually enjoy the DSA.

<!-- Built With -->

### Built With

<ul>
  <li>
    <a href="https://www.java.com/en/">
      <img
        src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"
        alt="Java Shield"
      />
    </a>
  </li>
  <li>
    <a href="https://tailwindcss.com">
      <img
        src="https://img.shields.io/badge/TypeScript-007ACC?style=for-the-badge&logo=typescript&logoColor=white"
        alt="Typescript Shield"
      />
    </a>
  </li>
</ul>
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->

## Getting Started

If you want to build a similar repo, you can use setup the project as follows

### Prerequisites

#### Java

- Install JDK version 21
- Setup Maven using my `pom.xml`

#### Typescript

- Install Bun
- bun
  ```sh
  bun install
  ```

<!-- USAGE EXAMPLES -->

## Usage

### Java

- Create a file under the `solutions` folder in `java` folder for your problem
    - Convention: Problem name in Pascal Case
- Extend the `abstract class DSAProblem<Input, Output>` and implement all abstract methods
- Create an implementation of your solutions and annotate them with `@Solution` annotation, so they get picked up and
  tested against all the test-cases
- Create a test file for your problem in test package and run them

### Typescript

- Create a file in `typescript` folder for your problem
    - Convention: Problem name in Pascal Case
- Implement the `interface Solution` in your problem class
- At end of the file add following code `new ManualTesting().test(new Problem())`
- Run `bun run <path-to-your-file> --watch` and whenever you make a change in your file, it will auto-run the test-cases
  for you, against all your implementations

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create, but
since it's not a regular project here contributing is not allowed. You can suggest me some good problems
though, either create a issue or hit me up on my socials.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- LICENSE -->

## License

Distributed under the MIT License. See `LICENSE` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->

## Author

- Website - [Ujjwal Garg](https://github.com/ujjwalgarg100204)
- Instagram - [@ujjwalgarg100204](https://www.instagram.com/ujjwalgarg100204/)
- Linkedin - [@ujjwalgarg100204](https://www.linkedin.com/in/ujjwal-garg-3a5639243/)
- Twitter -[@UjwalGarg100204](https://twitter.com/UjwalGarg100204)

<p align="right">(<a href="#readme-top">back to top</a>)</p>
