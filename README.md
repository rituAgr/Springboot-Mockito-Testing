### Simple Springboot Project to practice various testing techniques - 

1.  A mock is a fake object that has the same methods as the real class, but the methods do not have any actual code inside of them. All mocks return null (or 0 in the case of primitives) unless specified to return something.
2.  This will allow us to call all the normal methods of the object while still tracking every interaction, just as we would with a mock.
Look at class unit test with name ```ProfessorControllerTest_Spy```. It has example of how to use spy with and without stub



#### Mock vs. Spy in Mockito

Now – let's discuss the difference between Mock and Spy in Mockito – not the theoretical differences between the two concepts, just how they differ within Mockito itself.

When Mockito creates a mock – it does so from the Class of a Type, not from an actual instance. The mock simply creates a bare-bones shell instance of the Class, entirely instrumented to track interactions with it.

On the other hand, the spy will wrap an existing instance. It will still behave in the same way as the normal instance – the only difference is that it will also be instrumented to track all the interactions with it.

In the following example – we create a mock of the ArrayList class:

```
@Test
public void whenCreateMock_thenCreated() {
    List mockedList = Mockito.mock(ArrayList.class);
 
    mockedList.add("one");
    Mockito.verify(mockedList).add("one");
 
    assertEquals(0, mockedList.size());
}
```

As we can see – adding an element into the mocked list doesn't actually add anything – it just calls the method with no other side-effect.

A spy on the other hand will behave differently – it will actually call the real implementation of the add method and add the element to the underlying list:
```
@Test
public void whenCreateSpy_thenCreate() {
    List spyList = Mockito.spy(new ArrayList());
 
    spyList.add("one");
    Mockito.verify(spyList).add("one");
 
    assertEquals(1, spyList.size());
}
```


Helpful links - 
* https://www.path-to-programming.tech/posts/mockito/
* https://www.baeldung.com/mockito-spy


#### ArgumentCaptor

* Looks at ProfessorServiceTest_ArgumentCaptor file


