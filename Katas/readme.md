# Sources

Some are well known and first author is not so easy to find (if you know them, tell me).

Concurrency :

[from "Concurrent and real-time programming in Java"](https://www.cs.york.ac.uk/rts/books/CRTJbook.html)

It contains a study on finding all paths through a maze (aka kind of graph with a start and an end)
* first find all paths, managing choices at intersection by having current thread take a choice, and lauching a thread per other choices.
* then stop all searches when a first path is found
* then make a thread pool to avoid flooding your jvm with starving threads.

[from seven Concurrency Models in Seven Weeks](https://pragprog.com/titles/pb7con/source_code)

