package com.android.tyliumtrading.model;

import java.util.Comparator;

public class TradingDataComparator {

    private static int extractInt(String s) {
        String num = s.replaceAll("\\D", "");
        // return 0 if no digits found
        return num.isEmpty() ? 0 : Integer.parseInt(num);
    }

    public static class NameSorter implements Comparator<TradingData> {

        private boolean isNameClicked;

        public NameSorter(boolean isNameClicked) {
            this.isNameClicked = isNameClicked;
        }

        public int compare(TradingData o1, TradingData o2) {
            if (isNameClicked) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return o2.getName().compareTo(o1.getName());
            }
        }
    }

    public static class SymbolSorted implements Comparator<TradingData> {

        private boolean isSymbolClicked;

        public SymbolSorted(boolean isSymbolClicked) {
            this.isSymbolClicked = isSymbolClicked;
        }

        public int compare(TradingData o1, TradingData o2) {
            if (isSymbolClicked) {
                return o1.getCanonical_symbol().compareTo(o2.getCanonical_symbol());
            } else {

                return o2.getCanonical_symbol().compareTo(o1.getCanonical_symbol());
            }
        }
    }


}
