#include <fstream>
#include <iostream>
#include <bitset>

int main() {
  std::fstream file("a.out", std::ios::in | std::ios::binary);
  std::ofstream output("test.txt");

  char buffer[39000];
  file.read(buffer, 39000);

  std::string ascii;

  for (int i = 0; i < 39000; i++) {
    std::bitset<8> bits(buffer[i]);
    output << bits.to_string() << " ";
  }

  file.close();
  output.close();

  return 0;
}
