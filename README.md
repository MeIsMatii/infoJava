```text
/ (Root)
├── example/              # Example implementations
│   ├── linux/            # Linux-specific build configs (sources missing)
│   └── windows/          # Windows-specific build configs and assets (sources missing)
│       ├── images/       # Game sprites and textures (PNG/GIF)
│       └── ...           # Other build artifacts
├── projects/
│   ├── 2_OOP_1-3/        # Main project 1       
│   │   ├── src/          # Source code (.java files)
│   │   └── ...           # Config files
│   └── 2_VOOP_4_Inventar/  # Main project 2
│       └── src/          # Source code (.java files)
└── README.md
```
## Setup
To setup a project, you must copy the `linux`/`windows` (OS-specific) folder and put it in the `projects` folder. 

After that, you can create/copy the `src` folder. Upon pushing, only the `src` folder will be pushed, so people cloning it can set it up OS-specific

## Renaming
To rename the project, you must go to `Refactor > Rename` and type the new name in there. Then close intelliJ and rename the folder itself (i think)
You also need to go to `File > Project Structure > Project` and change `os.iml` to `<newName>.iml`
If it works, good. If it doesn't, problem for future me :D
