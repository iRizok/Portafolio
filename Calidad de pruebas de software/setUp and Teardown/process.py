class FileReader:
    # Initialize the values needed to read the file
    def __init__(self):
        self.file = None
        self.line = None
        self.num_lines = 0
        self.file_name = None

    # Set the file path
    def setFilePath(self, file_name):
        self.file_name = file_name

    # Open the file
    def openFile(self):
        self.file = open(self.file_name, "r")

    # Read the file
    def getText(self):
        self.num_lines = sum(1 for line in self.file)
        self.file.seek(0)
        self.line = self.file.readlines()
        return self.line

    # Close the file
    def closeFile(self):
        self.file.close()

def main():
    file_reader = FileReader()
    file_reader.setFilePath("file.txt")

    print("Opening file...")
    file_reader.openFile()

    print("Getting text...")
    print(file_reader.getText())

    print("Closing file...")
    file_reader.closeFile()

if __name__ == "__main__":
    main()