package com.lld.filesystem;

import lombok.Getter;

@Getter
abstract class FileSystemEntry {
    String name;
    Folder parent;

    public String getPath(){
        return "";
    }
}
