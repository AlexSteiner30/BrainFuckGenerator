#include <iostream>
#include <fstream>

void printString(std::string input)
{
    std::string startingString;
    int count = 0;

    for(int i = 0; i < input.size(); i++)
    {
        for(int j = 0; j < (int)input[i]; j++)
        {
            startingString += "+";
        }

        count = (int)input[i];
        startingString += ".>";
    }

    std::ofstream file;
    file.open ("test.bf");
    file << startingString;
    file.close();
}

int main()
{
    std::cout << "What do you want to print in brain fuck: ";

    std::string input;
    std::cin >> input;

    printString(input);

    system("brainfuck test.bf");
    return 0;
}