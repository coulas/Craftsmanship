# Sources

## Introduction
Introduction are well known Katas used as first exercises to make a contact with some new practices or to demo them in live coding.
Another way to put it, they are the shortest exercises, I know.

## Cyber-dojo
[from cyber-dojo](http://cyber-dojo.org/) :
You'll have almost all public green field katas here.
Green field means without starting code.
Usually, refactoring katas starts from existing code and are described as brown field.

## Test Driven Development
The TDD directory contains green field Kata that are either public and not yet in cyber-dojo, or copyrighted katas.

## Refactoring
This directory contains brownfield katas that aim at testing, refactoring and cleaning existing code.

## Concurrency
Concurrency is hard to develop ANd hard to test.
Hopefully we rarely need it.
The concurrency problem appears only when you have a shared mutable state, so :

1. Do not share a mutable state
2. Make a shared state immutable
3. Share objects that have no states

If you can't make it, you'll have a problem to guaranty consistent shared mutable states...
