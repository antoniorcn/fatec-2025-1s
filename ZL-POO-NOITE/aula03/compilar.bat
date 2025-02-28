rmdir ./build /S /Q
mkdir build

javac -d ./build edu/curso/*.javac
java -cp .;./build edu.curso.GaragemTeste