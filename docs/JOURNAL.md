# Dev Journal

All kinds of hate speech about Java, JDK, OOP, patterns, absence of ADTs, my design and project choices, and probably life choices in general. And also just traditional dev logs.

Please, pleeease don't read this crap, save yourself some time.

## Table of Contents

- [Table of Contents](#table-of-contents)
- [Day 1](#day-1)
- [Day 2](#day-2)
  - [To return or not to return](#to-return-or-not-to-return)
  - [Deep Visitor](#deep-visitor)

## Day 1

> why are you not Haskell?

From the get-go, I had a lot of trouble trying to fit the definition of JSON elements (which is best described in tagged union notation below) and just ended up trying to implement a common interface for what you can do with one such element.

```Haskell
data JSON
    = JSONNull
    | JSONBool Bool
    | JSONInt Integer
    | JSONFloat Float
    | JSONString String
    | JSONArray [JSON]
    | JSONObject [(String, JSON)]

-- JSON as a tagged union
```

At first, it just had a render method because it was pretty inconceivable to let JSON elements parse themselves. Right? Like, how would you know which element has to be called (although you def can separate detection from actual parsing)? However, I gave up on this interface, mostly because it was still causing a bit more coupling than I'm willing to accept.

Gotta say I'm bad at telling the difference between coupling and encapsulation sometimes. But this time, I do think that the only thing a JSON element can do without violating the SRP is to hold its value (which possibly includes references to its children) and "know" what kind of element it is. The latter is implemented by accepting a JSON visitor and calling the corresponding method on it. That is ofc all well and good, but that's where the rainbow land ends.

## Day 2

### To return or not to return

See, at this moment, I'm implementing a JSON renderer, which is a `visitor` acceptable by an `element` object. Conventionally, we call the `element` passing the `visitor` as an argument, but where does the output go? In this case, the return is a `string` value, but it may not be the same for another visitor. I can't couple the type or even the presence of the output of `element.accept(visitor)`. It seems like this situation needs some sort of *triple dispatch* solution, but I have no clue what it should be. The working way is to implement some kind of output accumulation in the `renderer` and then have it all put together and returned from a separate method?

That would not be a straightforward solution, though. JSON type being recursive would complicate trying to populate the accumulator of string output with representations of different elements, or at least, so it seems. Perhaps, it is also possible to create a copy of JSON AST with some kind of renderable interface and then have `renderer` convert one to the other, but that seems way too complicated.

### Deep Visitor

After a few minutes of mindlessly implementing some boilerplate methods on the renderer class, I came up with a bizarre idea for representing recursive rendering:

    String itemRepString = new JSONRenderer().render(item);

Yep, creating a blank visitor (with an empty `renderText` field) for every nested render call. Instantiating a heap of objects (no pun intended) to be garbage collected as soon as the top-level visitor is through with the render call. Well, maybe GC won't consume them that promptly, which only makes it worse, memory-consumption-wise.

Total side note, I also don't think a unified JSON formatting is that easy here. Or rather, the JSON formatting isn't unified. The problem, as it often stands in this project, is in nestable element types. See, arrays and objects, usually, are inlined when sufficiently short. How short is short enough is not 100% clear. Having other compound elements inside usually does make an element too long. Well, except for the case where the subelements are sufficiently short for still allowing the parent's inlining. The point here being, it's a mess! Probably, I should just find a way to ignore this problem at all or design my solution so that it allows for adding more fine-grained formatting incrementally. But how?!

Anyway, for now, I won't inline anything. That will make small arrays and objects look kinda weird but will actually clarify the visual structure of the render and, most importantly, remove a lot of my headache. Ah, splendid! That's probably the best design decision made so far, lol.