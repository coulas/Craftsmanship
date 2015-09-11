using NUnit.Framework;

namespace CSharpBasicLoop
{
    [TestFixture]
    public class BasicLoopTests
    {
        [Test]
        public void Should_handle_input()
        {
            Assert.AreEqual("< foobar", new BasicLoop().DoSomethingWithInput("foobar"));
        }
    }
}
