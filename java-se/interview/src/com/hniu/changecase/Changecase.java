package com.hniu.changecase;

import javafx.scene.control.TextFormatter;

public class Changecase {
    private String[] capital = {"", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    public static void main(String[] args) {
        Changecase changecage = new Changecase();
        changecage.numberChangecase("1232113210");
    }

    /*
     * 将数字转换成中国大写
     *
     * @param number 要转换的阿拉伯数字
     * @return 中国大写数字
    */
    private void numberChangecase(String number) {
        // 创建一个容器用来装大写数字
        StringBuilder builder = new StringBuilder();
        // 将数字转换成数字
        if (number.contains(".")) {// 有小数点
            // 取出小数点前的数字，转换大写数字
            builder.append(getCapital(number.substring(0, number.lastIndexOf("."))));
            // 取出小数点后的数字,进行转换
            builder.append(getCapital(number.substring(number.indexOf(".") + 1, number.indexOf(".") + 3)));
        } else {// 没有小数点
            builder.append(getCapital(number));
        }
        System.out.println(builder.toString());
    }

    /*
     * 转换出大写数字
     *
     * @param number 要转换的数字
     * @return
    */

    private String getCapital(String number) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            // 将字符串每次切除一个
            String substring = number.substring(i, number.length());
            // 求出每一个为的数字
            Integer result = Integer.parseInt(substring) / Integer.parseInt(getDivisor(substring));
            switch (substring.length()) {
                case 1:
                    builder.append(capital[result]);
                    builder.append("元");
                    break;
                case 2:
                    builder.append(capital[result]);
                    builder.append("拾");
                    break;
                case 3:
                    builder.append(capital[result]);
                    builder.append("佰");
                    break;
                case 4:
                    builder.append(capital[result]);
                    builder.append("仟");
                    break;
                case 5:
                    builder.append(capital[result]);
                    builder.append("万");
                    break;
                case 6:
                    builder.append(capital[result]);
                    builder.append("拾");
                    break;
                case 7:
                    builder.append(capital[result]);
                    builder.append("佰");
                    break;
                case 8:
                    builder.append(capital[result]);
                    builder.append("仟");
                    break;
                case 9:
                    builder.append(capital[result]);
                    builder.append("亿");
                    break;
                case 10:
                    builder.append(capital[result]);
                    builder.append("拾");
                    break;
                case 11:
                    builder.append(capital[result]);
                    builder.append("佰");
                    break;
                case 12:
                    builder.append(capital[result]);
                    builder.append("仟");
                case 13:
                    builder.append(capital[result]);
                    builder.append("万");
                case 14:
                    builder.append(capital[result]);
                    builder.append("拾万");
                    break;
                case 15:
                    builder.append(capital[result]);
                    builder.append("百万");
                    break;
                case 16:
                    builder.append(capital[result]);
                    builder.append("仟万");
                    break;
                case 17:
                    builder.append(capital[result]);
                    builder.append("亿亿");
                    break;
            }
        }
        return builder.toString();
    }

    /*
     * 获取除数
     *
     * @param strNumber 根据对应的字符得到对应的除数
     * @return 除数
    */
    private String getDivisor(String strNumber) {
        // 创建容器
        StringBuilder builder = new StringBuilder();
        builder.append("1");
        String number = strNumber.toString();
        for (int i = 0; i < number.length() - 1; i++) {
            builder.append("0");
        }
        return builder.toString();
    }

}