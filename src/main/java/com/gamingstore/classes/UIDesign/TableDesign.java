package com.gamingstore.classes.UIDesign;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableDesign {
    public static JScrollPane createTable(String[][] data, String[] columnNames) {
        JTable table = new JTable(new DefaultTableModel(data, columnNames)) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row)) {
                    // Alternate row colors
                    component.setBackground(row % 2 == 0 ? Color.decode("#1d2a35") : Color.decode("#2c3e50"));
                    component.setForeground(Color.WHITE);
                } else {
                    component.setBackground(Color.decode("#9763F6"));
                    component.setForeground(Color.WHITE);
                }
                return component;
            }
        };

        table.setBackground(Color.decode("#1d2a35"));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Roboto", Font.PLAIN, 15));
        table.setRowHeight(35);
        table.setShowHorizontalLines(false);
        table.setGridColor(Color.decode("#34495e"));

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Roboto", Font.BOLD, 16));
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);

        JScrollPane tableScrollPane = new JScrollPane(table);


        tableScrollPane.setBorder(null);


        tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


        tableScrollPane.getViewport().setBackground(Color.decode("#1d2a35"));
        tableScrollPane.setBackground(Color.decode("#1d2a35"));

        return tableScrollPane;
    }

}
