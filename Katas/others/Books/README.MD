
Book names only :
* TDD by example
* Refactoring to patterns
* Growing objects using tests (aproximative title)


# Concurrency :
## Seven Models
[from seven Concurrency Models in Seven Weeks](https://pragprog.com/titles/pb7con/source_code) :
This source is copyrighted and the author ask to not use it to make our own material.
Theses exercises are there for my own personal reference.
If you have any question about them, ask its author, buy his book, etc.

## Concurrent and Real-Time in Java
[from "Concurrent and real-time programming in Java"](https://www.cs.york.ac.uk/rts/books/CRTJbook.html) :
Same as previous, see the book.
It contains a study on finding all paths through a maze (aka kind of graph with a start and an end)
* first find all paths, managing choices at intersection by having current thread take a choice, and lauching a thread per other choices.
* then stop all searches when a first path is found
* then make a thread pool to avoid flooding your jvm with starving threads.


