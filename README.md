# Quarkus and virtual threads

This application contains 2 examples with virtual threads:
- `ItemResource` - an example of a resource where virtual threads work as expected.
- `PinItemResource` - an example where there is pinning and virtual thread cannot be unmounted from the carrier thread. 

`junit5-virtual-threads` provides the ability to verify that a thread in not pinned.

Use Java 21 to build and run the application.

