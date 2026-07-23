Decorator Pattern — Notes

What this example demonstrates

- Component: `DataSource` — a simple interface with `writeData(String)` and `readData()`.
- Concrete component: `FileDataSource` — a class implementing `DataSource`. For this learning example it simulates file storage by keeping the latest written string in memory and printing when a write occurs.
- Concrete decorators: `CompressionDecorator` and `EncryptionDecorator` — both implement `DataSource` and wrap another `DataSource` instance. They add behavior before delegating to the wrapped instance.
- Composition: Because decorators implement the same interface, they can be stacked in any order. The demo (`DecoratorDemo`) shows two orders to highlight how ordering affects result.

Key learning points

- The Decorator pattern provides a flexible alternative to subclassing for extending functionality. Rather than creating many combinations via subclass explosion, you create small, composable decorator classes.
- Decorators forward requests to the wrapped component and can add behavior before/after delegation.
- Ordering matters: DecoratorA(DecoratorB(component)) is not the same as DecoratorB(DecoratorA(component)) if both modify data.

Implementation notes and choices

- This project uses simple string markers to "simulate" compression and encryption:
  - `CompressionDecorator` wraps data as `Compressed:(original)`
  - `EncryptionDecorator` wraps data as `Encrypted:[original]`
  These are toy implementations to demonstrate the structure and composition behavior. They are not real compression or encryption.

- `FileDataSource` is an in-memory simulation. The name is kept for familiarity, but it does not perform actual file I/O. Replace with a real file-backed implementation if needed.

- The decorators check `startsWith` and `endsWith` of their markers before attempting to unwrap. This is safer than relying on hard-coded substring indices.

Suggestions for improvements (good things to mention in an interview)

- Add an abstract `DataSourceDecorator` that implements `DataSource` and holds the wrapped `DataSource`. Concrete decorators can extend it and override only what they need. This removes duplication and clarifies intent.
- Provide unit tests (JUnit) that assert that writing then reading returns the original string for both decorator orders (or document when it does not).
- Implement a real `FileDataSource` using `java.nio.file` to demonstrate decorators in a more realistic I/O scenario.
- Add additional decorators to show other cross-cutting concerns (e.g., `BufferingDecorator`, `LoggingDecorator`, `AccessControlDecorator`).
- Consider immutability/defensive copying if the data type becomes more complex than String.

How to run the demo

From the module root run the demo class or use your IDE to run `com.lld.structural.decorator.DecoratorDemo`.

Expected output (approx):

--- Scenario 1: Encryption(Compression(File)) ---
Writing data to file: Compressed:(Hello, World!)
Read back: Hello, World!

--- Scenario 2: Compression(Encryption(File)) ---
Writing data to file: Encrypted:[Hello, Aman!]
Read back: Hello, Aman!

Notes about the output

- The demo prints a "Writing data to file" message from `FileDataSource` showing what the stored string looks like after all decorations are applied. The subsequent "Read back" line shows the unwrapped original string (since our decorators unwrap on read).

If you want, I can:
- Add an abstract base decorator and refactor the concrete decorators to extend it.
- Implement a real file-backed `FileDataSource`.
- Add JUnit tests demonstrating that writing then reading returns the original data for different decorator orderings.

