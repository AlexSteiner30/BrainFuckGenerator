#include <iostream>

std::string printString(std::string input)
{
    std::string output;

    for(int i = 0; i < input.size(); i++)
    {
        output += (int)input[0];
    }

    return output;
}

int main()
{
    std::cout << "What do you wanto to print in brain fuck: ";

    std::string input;
    std::cin >> input;

    std::string addCode = printString(input);
    std::cout << addCode;

    return 0;
}