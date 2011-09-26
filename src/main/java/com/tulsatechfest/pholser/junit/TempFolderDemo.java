package com.tulsatechfest.pholser.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class TempFolderDemo {
    @Rule public final TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void makeSomeFiles() throws Exception {
        File folder = tempFolder.newFolder("aFolder");
        File file = tempFolder.newFile("aFile");

        assertEquals(tempFolder.getRoot(), folder.getParentFile());
        assertEquals(tempFolder.getRoot(), file.getParentFile());
    }
}
