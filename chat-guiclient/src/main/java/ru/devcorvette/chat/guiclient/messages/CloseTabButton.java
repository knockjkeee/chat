package ru.devcorvette.chat.guiclient.messages;

import ru.devcorvette.chat.core.ResourceManager;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс для кнопки, которая закрывает вкладку Tab.
 */
class CloseTabButton extends JButton {
    private final Tab tab;
    private final TabManager tabManager;

    /**
     * @param tab        вкладка
     * @param tabManager tabManager
     */
    CloseTabButton(Tab tab, TabManager tabManager) {
        this.tab = tab;
        this.tabManager = tabManager;

        //настройка внешнего вида кнопки
        setIcon(ResourceManager.getImage("close.png"));
        setToolTipText("Выйти");
        setUI(new BasicButtonUI());
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setPreferredSize(new Dimension(16, 16));

        addActionListener(new CloseAction());
    }

    /**
     * Слушатель событий кнопки.
     */
    private class CloseAction implements ActionListener {
        /**
         * Если вкладка приватная - просто закрывает вкладку.
         * Если вкладка чат рум - отправляет запрос на сервер, вкладку закроет client
         * после подтверждения сервером.
         *
         * @param e е
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (tab.isPrivateRoom()) {
                synchronized (tabManager) {
                    tabManager.remove(tab);
                }
            } else {
                tabManager.sendLeaveRoomRequest(tab.getTitle());
            }
        }
    }
}
