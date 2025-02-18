# read_file.py
import os

def create_file(file_path):
    """Creates a file and writes a message if it doesn't exist."""
    with open(file_path, "w") as file:
        file.write("This is the content of the file created by the Python script.\n")
    print(f"File created and written to: {file_path}")

def read_file(file_path):
    """Reads and prints the content of the file."""
    if os.path.exists(file_path):
        with open(file_path, "r") as file:
            content = file.read()
            print("File content:")
            print(content)
    else:
        print(f"File not found: {file_path}")
        create_file(file_path)
        read_file(file_path)  # Retry after creating the file

def main():
    file_path = os.path.expanduser("~/Desktop/output.txt")
    read_file(file_path)

if __name__ == "__main__":
    main()
