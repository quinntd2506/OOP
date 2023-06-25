package aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import aims.cart.Cart;
import aims.exception.PlayerException;
import aims.media.Media;
import aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;
	private Cart cart;

	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.cart = cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);

		JLabel cost = new JLabel("" + media.getCost() + "$");
		cost.setAlignmentX(CENTER_ALIGNMENT);

		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));


		JButton btnCart = new JButton("Add to cart");
		btnCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String warning = cart.addMedia(media);
            	if (warning.isEmpty()) {
            	JOptionPane.showMessageDialog(null, "Media added to cart: " + media.getTitle(), "Playable Media", JOptionPane.INFORMATION_MESSAGE);
            	} else {
            		JOptionPane.showMessageDialog(null, warning, "Warning", JOptionPane.ERROR_MESSAGE);
            	}
            }
		});
		container.add(btnCart);

		if (media instanceof Playable) {
			JButton btnPlay = new JButton("Play");
			btnPlay.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						String playContent = media.playMedia();

						JOptionPane.showMessageDialog(null, playContent, "Playing media", JOptionPane.INFORMATION_MESSAGE);
					} catch (PlayerException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Illegal Media Length", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				}
			});
			container.add(btnPlay);
		}

		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
