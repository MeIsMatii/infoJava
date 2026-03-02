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
**SETUP**
To setup a project, you must copy the `linux`/`windows` (OS-specific) folder and put it in the `projects` folder.
Then create/copy the `src` folder. Upon pushing, only the `src` folder will be pushed, so people cloning it can do it OS-specific