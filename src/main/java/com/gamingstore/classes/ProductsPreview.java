package com.gamingstore.classes;

import com.gamingstore.classes.UIDesign.ProductPageUI;

public class ProductsPreview {
    private static void showProduct(String productID, String description, String imagePath) {
        String username = CurrentUser.getCurrentUser();
        new ProductPageUI(username, productID, description, imagePath);
    }

    public static void console1() {
        showProduct("CONSL001",
                "The PlayStation 5 pro(PS5) is Sony's next-gen console,<br/> offering fast load times, 4K graphics, ray tracing,<br/>and the immersive DualSense controller.<br/> It supports PS4 games and comes in physical and digital editions.",
                "Files\\DetailFrame\\1.png");
    }

    public static void console2() {
        showProduct("CONSL002",
                "The PlayStation 5 (PS5) is Sony's next-gen console,<br/> offering fast load times, 4K graphics, ray tracing,<br/>and the immersive DualSense controller.",
                "Files\\DetailFrame\\2.png");
    }
    public static void console3() {
        showProduct("CONSL003",
                "PlayStation 5 Pro with upgraded performance and 8K support.",
                "Files\\DetailFrame\\3.png");
    }
    public static void console4() {
        showProduct("CONSL004",
                "PlayStation 5 Pro with upgraded performance and 8K support.",
                "Files\\DetailFrame\\4.png");
    }

    public static void console5() {
        showProduct("CONSL005",
                "PlayStation 5 Pro with upgraded performance and 8K support.",
                "Files\\DetailFrame\\5.png");
    }

    public static void console6() {
        showProduct("CONSL006",
                "PlayStation 5 Pro with upgraded performance and 8K support.",
                "Files\\DetailFrame\\6.png");
    }

    public static void console7() {
        showProduct("CONSL007",
                "PlayStation 5 Pro with upgraded performance and 8K support.",
                "Files\\DetailFrame\\7.png");
    }

    public static void console8() {
        showProduct("CONSL008",
                "PlayStation 5 Pro with upgraded performance and 8K support.",
                "Files\\DetailFrame\\8.png");
    }

    public static void accessories1() {
        showProduct("GACC001",
                "PlayStation 5 Pro with upgraded performance and 8K support.",
                "Files\\DetailFrame\\11.png");
    }


    public static void accessories2() {
        showProduct("GACC002",
                "Cyberpunk 2077 is an open-world RPG set in Night City.",
                "Files\\DetailFrame\\12.png");
    }

    public static void accessories3() {
        showProduct("GACC003",
                "Call of Duty: Infinite Warfare is a futuristic first-person<br/> shooter featuring a campaign, multiplayer modes,<br/> and space combat.",
                "Files\\DetailFrame\\13.png");
    }

    public static void accessories4() {
        showProduct("GACC004",
                "The PlayStation 5 pro(PS5) is Sony's next-gen console,<br/> offering fast load times, 4K graphics, ray tracing,<br/>and the immersive DualSense controller.<br/> It supports PS4 games and comes in physical and digital editions.",
                "Files\\DetailFrame\\14.png");
    }

    public static void accessories5() {
        showProduct("GACC005",
                "The PlayStation 5 (PS5) is Sony's next-gen console,<br/> offering fast load times, 4K graphics, ray tracing,<br/>and the immersive DualSense controller.",
                "Files\\DetailFrame\\15.png");
    }
    public static void accessories6() {
        showProduct("GACC006",
                "PlayStation 5 Pro with upgraded performance and 8K support.",
                "Files\\DetailFrame\\16.png");
    }
    public static void accessories7() {
        showProduct("GACC007",
                "PlayStation 5 Pro with upgraded performance and 8K support.",
                "Files\\DetailFrame\\17.png");
    }

    public static void accessories8() {
        showProduct("GACC008",
                "PlayStation 5 Pro with upgraded performance and 8K support.",
                "Files\\DetailFrame\\18.png");
    }

    public static void game1() {
        showProduct("GAME001",
                "PlayStation 5 Pro with upgraded performance and 8K support.",
                "Files\\DetailFrame\\21.jpeg");
    }

    public static void game2() {
        showProduct("GAME002",
                "PlayStation 5 Pro with upgraded performance and 8K support.",
                "Files\\DetailFrame\\22.jpeg");
    }

    public static void game3() {
        showProduct("GAME003",
                "PlayStation 5 Pro with upgraded performance and 8K support.",
                "Files\\DetailFrame\\23.jpeg");
    }

    public static void game4() {
        showProduct("GAME004",
                "PlayStation 5 Pro with upgraded performance and 8K support.",
                "Files\\DetailFrame\\24.jpeg");
    }


    public static void game5() {
        showProduct("GAME005",
                "Cyberpunk 2077 is an open-world RPG set in Night City.",
                "Files\\DetailFrame\\25.jpeg");
    }

    public static void game6() {
        showProduct("GAME006",
                "Cyberpunk 2077 is an open-world RPG set in Night City.",
                "Files\\DetailFrame\\26.jpeg");
    }

    public static void game7() {
        showProduct("GAME007",
                "Call of Duty: Infinite Warfare is a futuristic first-person<br/> shooter featuring a campaign, multiplayer modes,<br/> and space combat.",
                "Files\\DetailFrame\\27.jpeg");
    }

    public static void game8() {
        showProduct("GAME008",
                "Call of Duty: Infinite Warfare is a futuristic first-person<br/> shooter featuring a campaign, multiplayer modes,<br/> and space combat.",
                "Files\\DetailFrame\\28.jpeg");
    }

    public static void main(String[] args) {
        ProductsPreview preview = new ProductsPreview();
        preview.console1();
    }
}
