#include <fstream>
#include <iostream>
#include <bitset>

int main() {
  std::fstream file("../Input/a.bin", std::ios::in | std::ios::binary);

  char buffer[39000];
  file.read(buffer, 39000);

  std::string ascii;

  for (int i = 0; i < 39000; i++) {
    std::bitset<8> bits(buffer[i]);
    std::cout << bits.to_string() << " ";
  }

  file.close();

  return 0;
}
