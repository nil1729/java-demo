## Completable Future: The Promises of Java

---

### Topics
- Lessons from `JavaScript` Callbacks
- Promises
  - may resolve, reject, or be pending
  - data channel and error channel
  - failure/error is like data
  - easy to compose
  - ```
         -x-F-x-F-------------x-F-x----
        P        \           /
         ---------E-F-E-F-E-F----------
    ```
- What about Java ?
- `CompletableFuture` in Java is Promises in JavaScript
- Stages
- One stage completes and another stage may run
- Create a completable future
- thread of execution
- changing the pool
- `thenAccept`
- `thenApply`
- `thenRun`
- creating pipe, then completing
- dealing with exceptions
- chaining
- succeed on timeout
- fail on timeout
- combine
- compose

---

```
Stream                        CompletableFuture
zero, one or more data        at most have one data or error

forEach - Consumer            thenAccept
          accept

map - Function                thenApply
      apply
      
reduce                        thenCombine
flatMap                       thenCompose


one to one function
Stream<T>.map(f11) => Stream<R>

one to many function
Stream<T>.map(f1n) => Stream<Stream<R>>

Stream<T>.flatMap(f1n) => Stream<R>
```

### References
- [CompletableFuture: The Promise of Java](https://youtu.be/9ueIL0SwEWI)