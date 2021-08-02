# To-Do

- [JSON manipulation features](#json-manipulation-features)
- [Concrete development goals](#concrete-development-goals)
- [Design patterns to check out](#design-patterns-to-check-out)
  - [Creational](#creational)
  - [Structural](#structural)
  - [Behavioral](#behavioral)
- [Java features to check out](#java-features-to-check-out)

## JSON manipulation features

- [ ] Rendering to string
- [ ] Parsing from string   
- [ ] Finding/aggregating elements
- [ ] AST maniputaion
- [ ] Schema-guided manipulation
- [ ] Java class serialization/deserialization

## Concrete development goals

- [ ] JSON AST and CST models
  - [x] representing any nested JSON data
  - [ ] destructuring
    - [ ] getting valuse out
    - [ ] support for standard interfaces (`Map`, `Iterable`, `Stream` etc)
  - [ ] modification
    - [ ] mutation - [ ] not sure though
    - [ ] copying
      - [ ] deep
      - [ ] shallow
  - [ ] JSON tree structure introspection
- [ ] Parsing
  - [x] Tokens
  - [x] Lexer
  - [ ] Token Parser
- [ ] Renderer
  - [x] Get the basic renderer up and and running
  - [ ] Proper printer
    - [x] JSON CST -> Tokens
    - [x] Printer: Tokens -> Text (basic and hacky)
    - [x] Printer interface, Pretty printer
    - [ ] Decoupled formatter for Printer
- [ ] other stuff to have in mind
  - [ ] Schema manager
    - [ ] Extract a schema from an CST and store it (or have schema represented as an actual CST)
    - [ ] check whether a given CST complies with a set schema
    - [ ] Schema-matching on a more complex tree
  - [ ] Java object serializaion
    - 

Each feature is implemented through a dedicated visitor class.

## Design patterns to check out

### Creational

- [ ] **Factory Method** that can then evolve into a **Builder**, or an **Abstract Factory** possibly implemended as a **Singleton**: building up a CST of a complex JSON object
- [ ] **Prototype Registry**: managing JSON schemas

### Structural

- [x] **Composite**: implementing a concrete JSON syntax tree
- [ ] **Fasade**: a cleaner API

### Behavioral

- [ ] **Visitor**: implementing [JSON manipulation features](#json-manipulation-features)
- [ ] **Strategy**: different JSON formatting schemes for the Renderer
> This behavior can also be achieved with the Template Method, but it relies on inheritance, thus making Strategy preferable

## Java features to check out

- implementing `Map` or `List` interface in custom objects for more idiomatic access and looping
- getting something like C++ initializer list for custom classes (possibly, `Map`s)