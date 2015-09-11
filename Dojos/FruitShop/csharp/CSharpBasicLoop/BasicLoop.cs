using System;

namespace CSharpBasicLoop
{
    public class BasicLoop
    {
        public void Loop()
        {
            String input;
            Console.WriteLine("> ");
            while ((input = Console.ReadLine()) != null)
            {          
                Console.WriteLine(DoSomethingWithInput(input));            
                Console.WriteLine("> ");
            }
        }

        public String DoSomethingWithInput(String input)
        {
            return "< " + input;
        }
    }
}
