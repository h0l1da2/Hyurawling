package app.rakuten.hyurawling.program;

import app.rakuten.hyurawling.frame.HyurawlingFrame;

import javax.swing.*;

public class CrawlingProgram {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HyurawlingFrame());
    }
}
