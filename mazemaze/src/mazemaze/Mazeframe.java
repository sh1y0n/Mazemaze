package mazemaze;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Mazeframe extends MyFrame {
	re ReRe=new re();
	public void run() {
		addKeyListener(ReRe);
		kabe();
	}

	public void kabe() {
		int[][] kabe = new int[15][15];
		Random rand = new Random();

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				kabe[i][j] = 0; //通路
				if (i % 2 == 0 && j % 2 == 0) {
					kabe[i][j] = 2; //たおす壁
				}
				if (i == 0 || j == 0 || i == 14 || j == 14) {
					kabe[i][j] = 1; //外周 
				}
			}

		}

		//棒倒しはじめ

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 15; j++) {

				if (kabe[i][j] == 2 && kabe[i][2] == 2) { //最初の一行目
					boolean owari = false;

					while (owari == false) {
						int k = rand.nextInt(4);//０下１左２右3上 

						if (k == 0 && kabe[i + 1][j] == 0) {
							kabe[i + 1][j] = 1;
							owari = true;

						}
						if (k == 1 && kabe[i][j - 1] == 0) {
							kabe[i][j - 1] = 1;
							owari = true;

						}
						if (k == 2 && kabe[i][j + 1] == 0) {
							kabe[i][j + 1] = 1;
							owari = true;

						}
						if (k == 3 && kabe[i - 1][j] == 0) {
							kabe[i - 1][j] = 1;
							owari = true;

						}
					}
				}
			}
		}
		for (int i = 3; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (kabe[i][j] == 2) { //二行目
					boolean owari = false;

					while (owari == false) {
						int k = rand.nextInt(3);//０下１左２右

						if (k == 0 && kabe[i + 1][j] == 0) {
							kabe[i + 1][j] = 1;
							owari = true;

						}
						if (k == 1 && kabe[i][j - 1] == 0) {
							kabe[i][j - 1] = 1;
							owari = true;

						}
						if (k == 2 && kabe[i][j + 1] == 0) {
							kabe[i][j + 1] = 1;
							owari = true;

						}

					}
				}
			}
		}

		MyFrame frame = this;

		frame.clear();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {

				if (kabe[i][j] == 1 || kabe[i][j] == 2) {
					frame.setColor(0, 0, 0);
					frame.fillRect(j * 20 + 50, i * 20 + 50, 20, 20); // 壁

				}
			}

		}

		frame.setColor(255, 0, 0); // スターと
		frame.fillRect(20 + 50, 20 + 50, 20, 20);
		frame.setColor(0, 0, 255); //ゴール
		frame.fillRect(13 * 20 + 50, 13 * 20 + 50, 20, 20);

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(kabe[i][j]);
			}
			System.out.println();
		}
	}
		public class re implements KeyListener {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO 自動生成されたメソッド・スタブ

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO 自動生成されたメソッド・スタブ
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					clear();
					kabe();
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO 自動生成されたメソッド・スタブ

			}

		}

	

}
