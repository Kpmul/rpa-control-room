# write_to_file.py
import os

def main():
    file_path = os.path.expanduser("~/Desktop/output.txt")  # Save to Desktop for visibility
    with open(file_path, "w") as file:
        file.write("This file was created by a Python script!\n")
    print(f"File created successfully: {file_path}")

if __name__ == "__main__":
    main()
