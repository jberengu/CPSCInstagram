package Instagram_GUI;

import Background_Code.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * This class deals with creating the profile pop up frame
 *
 * @author Jose
 */
public class ProfilePopUp extends javax.swing.JFrame {

    private String fileSeparator = System.getProperty("file.separator");
    private String workingDir = System.getProperty("user.dir");
    private String imagesDir =  workingDir + fileSeparator + "src"
            + fileSeparator + "Images" + fileSeparator;
    int width = (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - 262;
    int height = (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - 250;

    /**
     * Constructor for the profile pop up frame
     *
     * @param i profile icon
     * @param username profile username
     * @param firstname profile first name
     * @param lastname profile last name
     * @param followers profile number of followers
     * @param following profile number of following
     * @param follow whether or not the current user is following lookAt user
     * @param lookAt user that is being looked at
     * @param current the current user that is logged in
     * @param privacy the privacy setting for lookAt user
     */
    public ProfilePopUp(Icon i, String username, String firstname,
            String lastname, int followers, int following, boolean follow,
            RealProfile lookAt, RealProfile current, boolean privacy) {
        initComponents();
        this.setTitle("EagleGram");
        this.setLocation(width, height);

        this.current = current;
        this.lookAt = lookAt;
        this.follow = follow;

        if (current.equals(lookAt)
                || current.getUsername().equals(main.getLoggedIn().getUsername())) {
            followButton.setEnabled(false);
        }

        profilePictureLabel.setIcon(i);
        usernameLabel.setText(username);
        firstNameLabel.setText(firstname);
        lastNameLabel.setText(lastname);
        followersLabel.setText(Integer.toString(followers) + " followers");
        followingLabel.setText(Integer.toString(following) + " following");
        if (this.follow) {
            followButton.setText("unFollow");
        }

        if (privacy) {
            boolean isFollowed = false;
            for (int z = 0; z < lookAt.getFollowing().size(); z++) {
                if (lookAt.getFollowing().get(z).getUsername().equals(
                        current.getUsername())) {
                    isFollowed = true;
                    if (lookAt != null) {
                        for (int j = 0; j < lookAt.getPosts().size(); j++) {
                            profilePostsPanel.add(new UserPanel(
                                    lookAt.getPosts().get(j).getImage(),
                                    lookAt.getPosts().get(j).getCaption(),
                                    lookAt.getPosts().get(j).getDate(),
                                    lookAt.getPosts().get(j).getLikes(),
                                    true));
                            profilePostsPanel.revalidate();
                            profilePostsPanel.repaint();
                        }
                    }
                }
            }
            if (!isFollowed) {
                ImageIcon picture = null;
                try {
                    picture = new ImageIcon(scaleImage(
                            120, 120, ImageIO.read(new File(imagesDir
                                    + "LockedAccount.png"))));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                profilePostsPanel.add(new UserPanel(
                        picture,
                        "This user has a\n"
                        + "private account.\n"
                        + "They need to be\n"
                        + "following you\n"
                        + "for you to view\n"
                        + "the account.",
                        null, 0, false));
                profilePostsPanel.revalidate();
                profilePostsPanel.repaint();
            }

        } else {
            if (lookAt != null) {
                for (int j = 0; j < lookAt.getPosts().size(); j++) {
                    profilePostsPanel.add(new UserPanel(
                            lookAt.getPosts().get(j).getImage(),
                            lookAt.getPosts().get(j).getCaption(),
                            lookAt.getPosts().get(j).getDate(),
                            lookAt.getPosts().get(j).getLikes(), true));
                    profilePostsPanel.revalidate();
                    profilePostsPanel.repaint();
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        staticProfilePanel = new javax.swing.JPanel();
        profilePictureLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        followersLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        followingLabel = new javax.swing.JLabel();
        followButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        profilePostsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        staticProfilePanel.setPreferredSize(new java.awt.Dimension(536, 88));

        try {
            ii=new ImageIcon(scaleImage(77, 77, ImageIO.read(new File(imagesDir
                + "ProfilePicture.png"))));//get the image from file chooser and scale it to match JLabel size
profilePictureLabel.setIcon(ii);
} catch (Exception ex) {
    ex.printStackTrace();
    }

    usernameLabel.setText("Username");
    usernameLabel.setPreferredSize(new java.awt.Dimension(100, 21));

    firstNameLabel.setText("First name");
    firstNameLabel.setPreferredSize(new java.awt.Dimension(100, 21));

    followersLabel.setText("# followers");
    followersLabel.setPreferredSize(new java.awt.Dimension(100, 21));

    lastNameLabel.setText("Last name");
    lastNameLabel.setPreferredSize(new java.awt.Dimension(100, 21));

    followingLabel.setText("# following");
    followingLabel.setPreferredSize(new java.awt.Dimension(100, 21));

    followButton.setCursor(Cursor.getPredefinedCursor(
        Cursor.HAND_CURSOR));
followButton.setText("Follow");
followButton.setPreferredSize(new java.awt.Dimension(100, 21));
followButton.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        followButtonActionPerformed(evt);
    }
    });

    javax.swing.GroupLayout staticProfilePanelLayout = new javax.swing.GroupLayout(staticProfilePanel);
    staticProfilePanel.setLayout(staticProfilePanelLayout);
    staticProfilePanelLayout.setHorizontalGroup(
        staticProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(staticProfilePanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(profilePictureLabel)
            .addGap(18, 18, 18)
            .addGroup(staticProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(staticProfilePanelLayout.createSequentialGroup()
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(followersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(followingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(followButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(staticProfilePanelLayout.createSequentialGroup()
                    .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    staticProfilePanelLayout.setVerticalGroup(
        staticProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staticProfilePanelLayout.createSequentialGroup()
            .addContainerGap(33, Short.MAX_VALUE)
            .addGroup(staticProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(staticProfilePanelLayout.createSequentialGroup()
                    .addGroup(staticProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(followersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(followingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(followButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(staticProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(profilePictureLabel))
            .addContainerGap())
    );

    jScrollPane1.setPreferredSize(new java.awt.Dimension(534, 404));

    profilePostsPanel.setMinimumSize(new java.awt.Dimension(534, 404));

    javax.swing.GroupLayout profilePostsPanelLayout = new javax.swing.GroupLayout(profilePostsPanel);
    profilePostsPanel.setLayout(profilePostsPanelLayout);
    profilePostsPanelLayout.setHorizontalGroup(
        profilePostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 534, Short.MAX_VALUE)
    );
    profilePostsPanelLayout.setVerticalGroup(
        profilePostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 404, Short.MAX_VALUE)
    );

    jScrollPane1.setViewportView(profilePostsPanel);
    profilePostsPanel.setLayout(new BoxLayout(profilePostsPanel, BoxLayout.Y_AXIS));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(staticProfilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(staticProfilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Changes the state of the follow button as well as adds a follower to
     * lookAt user and a following to current user
     *
     * @param evt when the follow button is clicked
     */
    private void followButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followButtonActionPerformed
        // TODO add your handling code here:
        if (follow == false) {

            //add users togeather
            follow = true;

            current.addFollowing(lookAt);
            lookAt.addFollower(current);

            followersLabel.setText(lookAt.getFollowers().size() + " Followers");
            followingLabel.setText(lookAt.getFollowing().size() + " Following");

            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
            String time = format.format(date);
            lookAt.addNotification(current, lookAt, time,
                    "followed you", null, "follow");

            followButton.setText("unFollow");

            main.output();
        } else {
            //do stuff
            follow = false;

            current.removeFollowing(lookAt);
            lookAt.removeFollower(current);

            followersLabel.setText(lookAt.getFollowers().size() + " Followers");
            followingLabel.setText(lookAt.getFollowing().size() + " Following");

            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
            String time = format.format(date);
            lookAt.addNotification(current, lookAt, time,
                    "unfollowed you", null, "follow");

            followButton.setText("Follow");

            main.output();
        }
    }//GEN-LAST:event_followButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProfilePopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfilePopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfilePopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfilePopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProfilePopUp(null, "username", "firstname",
                        "lastname", 0, 0, false, null, null, false).setVisible(true);
            }
        });
    }

    /**
     * Processes an image to be used with a jLabel
     *
     * @param w width of the image
     * @param h height of the image
     * @param img image that is to be processed
     * @return returns the processed image
     * @throws Exception ---
     */
    public static BufferedImage scaleImage(int w, int h, BufferedImage img)
            throws Exception {
        BufferedImage bi;
        bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(img, 0, 0, w, h, null);
        g2d.dispose();
        return bi;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JButton followButton;
    private javax.swing.JLabel followersLabel;
    private javax.swing.JLabel followingLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel profilePictureLabel;
    private javax.swing.JPanel profilePostsPanel;
    private javax.swing.JPanel staticProfilePanel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
    private CurrentProfile main = new CurrentProfile();
    private RealProfile lookAt;
    private RealProfile current;
    private boolean follow;
    private static ImageIcon ii;

    /**
     * Creates a new panel for the users post
     */
    private class UserPanel extends JPanel {

        /**
         * Constructor for UserPanel
         *
         * @param ii icon for this post
         * @param caption caption for this post
         * @param date date this post was posted
         * @param likes number of like this post has
         * @param privacy privacy setting of the owner of this post
         */
        public UserPanel(Icon ii, String caption, String date, int likes,
                boolean privacy) {
            setLayout(new GridBagLayout());
            Border emptyBorder = BorderFactory.createEmptyBorder(2, 2, 2, 2);
            Border lineBorder = BorderFactory.createLineBorder(Color.black);
            setBorder(BorderFactory.createCompoundBorder(lineBorder,
                    emptyBorder));

            JLabel timeLabel = new JLabel();
            timeLabel.setSize(100, 21);
            timeLabel.setText(date);
            add(timeLabel, createGbc(3, 0));

            JLabel pictureLabel = new JLabel();
            pictureLabel.setSize(120, 120);
            try {
                pictureLabel.setIcon(ii);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (privacy) {
                pictureLabel.setCursor(Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR));
                pictureLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        //PostPopUp frame= new PostPopUp(ii, username, likes, liked,
                        //      caption, "comments", "hashtags","people");

                        //frame.setVisible(true);
                    }
                });
            }
            add(pictureLabel, createGbc(0, 0));

            JTextArea captionText = new JTextArea();
            captionText.setText(caption);
            captionText.setLineWrap(true);
            captionText.setEditable(false);
            captionText.setSize(120, 120);
            JScrollPane captionScroll = new JScrollPane(captionText,
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            captionScroll.setSize(120, 120);
            add(captionText, createGbc(1, 0));

            if (privacy) {
                final JLabel likeLabel = new JLabel();
                likeLabel.setText("LIKES: " + Integer.toString(likes));
                likeLabel.setSize(100, 21);
                add(likeLabel, createGbc(2, 0));
            }

        }

        /**
         * Positions the different components
         *
         * @param x x coordinate
         * @param y y coordinate
         * @return returns all of the positioned component
         */
        private GridBagConstraints createGbc(int x, int y) {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = x;
            gbc.gridy = y;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.WEST;

            return gbc;
        }
    }
}