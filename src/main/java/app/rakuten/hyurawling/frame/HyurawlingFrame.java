package app.rakuten.hyurawling.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class HyurawlingFrame extends JFrame {
    private JTextField urlTextField;
    private JTextField minTextField;
    private JTextField maxTextField;
    private JTextField marginTextField;
    private JTextField commissionTextField;
    private JTextField shippingTextField;
    private JTextField fileNameTextField;
    private JTextField folderPathTextField;

    public HyurawlingFrame() {

        setTitle("라쿠텐 휴롤링");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        // URL 라벨 및 텍스트 필드 추가
        add(new JLabel("URL:"), gbc);

        gbc.gridy++;
        urlTextField = new JTextField();
        gbc.gridwidth = 2; // URL 칸은 2칸을 차지하도록 함
        gbc.fill = GridBagConstraints.HORIZONTAL; // 수평으로 늘어나도록 함
        add(urlTextField, gbc);

        gbc.gridwidth = 1; // 다음에 추가되는 컴포넌트는 1칸만 차지하도록 초기화

        // 나머지 라벨 및 텍스트 필드 추가
        gbc.gridy++;
        add(new JLabel("시작 페이지:"), gbc);

        gbc.gridy++;
        minTextField = new JTextField();
        add(minTextField, gbc);

        gbc.gridy++;
        add(new JLabel("끝 페이지:"), gbc);

        gbc.gridy++;
        maxTextField = new JTextField();
        add(maxTextField, gbc);

        gbc.gridy++;
        add(new JLabel("마진:"), gbc);

        gbc.gridy++;
        marginTextField = new JTextField();
        add(marginTextField, gbc);

        gbc.gridy++;
        add(new JLabel("쿠팡 수수료:"), gbc);

        gbc.gridy++;
        commissionTextField = new JTextField();
        add(commissionTextField, gbc);

        gbc.gridy++;
        add(new JLabel("배송비:"), gbc);

        gbc.gridy++;
        shippingTextField = new JTextField();
        add(shippingTextField, gbc);

        gbc.gridy++;
        add(new JLabel("파일 이름:"), gbc);

        gbc.gridy++;
        fileNameTextField = new JTextField();
        add(fileNameTextField, gbc);

        gbc.gridy++;
        add(new JLabel("폴더 경로:"), gbc);

        gbc.gridy++;
        folderPathTextField = new JTextField();
        add(folderPathTextField, gbc);

        // 폴더 찾아보기 버튼 추가
        gbc.gridy++;
        JButton browseButton = new JButton("폴더 찾아보기");
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browseFolder();
            }
        });
        add(browseButton, gbc);

        gbc.gridy++;
        JButton startButton = new JButton("시작하기");
        add(startButton, gbc);
        // 버튼 추가 (만약 필요하면)
        // gbc.gridy++;
        // JButton calculateButton = new JButton("계산하기");
        // add(calculateButton, gbc);

        // 프레임 설정 마무리
//        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void browseFolder() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFolder = fileChooser.getSelectedFile();
            folderPathTextField.setText(selectedFolder.getAbsolutePath());
        }
    }
}
