# To-Do

- [To-Do](#to-do)
  - [JSON manipulation features](#json-manipulation-features)
  - [Design patterns to check out](#design-patterns-to-check-out)
    - [Creational](#creational)
    - [Structural](#structural)
    - [Behavioral](#behavioral)

## JSON manipulation features

- [ ] Rendering to string
- [ ] Parsing from string   
- [ ] Finding/aggregating elements
- [ ] AST maniputaion
- [ ] Schema-guided manipulation
- [ ] Java class serialization/deserialization

Each feature is implemented throung a dedicated visitor class.

## Design patterns to check out

### Creational

- [ ] **Factory Method** that can then evolve into a **Builder**, or an **Abstract Factory** possibly implemended as a **Singleton**: building up a AST of a complex JSON object
- [ ] **Prototype Registry**: managing JSON schemas

### Structural

- [ ] **Composite**: implementing a concrete JSON syntax tree
- [ ] **Fasade**: a cleaner API

### Behavioral

- [ ] **Visitor**: implementing [JSON manipulation features](#json-manipulation-features)
- [ ] **Strategy**: different JSON formating schemes for the Renderer
> This behavior can also be achieved with the Template Mathod, but it relies on inheritance, thus making Strategy preverable
****