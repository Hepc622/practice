package chat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class APP {
	public static void main(String[] args) throws IOException {
		String[] strs = {"香蕉","蝴蝶","汽车","母牛","球","小孩","手指","鸡","热水瓶","钥匙","蜜蜂","风扇","叶子","吹","拖拉机","孔雀","女孩","河流","罐头","裙子","鼓","信封","指挥","皇后","徽章","放映机","打结","鞭子","捉","转盘","车厢","教师","挖","箭","木棍","装配","缝","船长","网","漏斗","潜艇","香肠","采","倒","砂锅","信号","豆荚","鹰","风镜","搓","栏杆","一群","帆","羚羊","演说家","升起","宣誓","豁口","刻度","通讯","柜台","袋鼠","胶囊","事故","体育场","挖掘","绿洲","警戒","垄沟","蜂巢","阻挡","攻击","化学家","障碍","家庭用具","驮","学者","礼节","旅行","同心圆","旋管","争论","上钩","华表","浸泡","运输","横梁","同胞","平衡","商标","雕塑","窗帷","失望","切线","沉思","绝技","犬","奇迹","鉴定","北极","惊讶","两栖类","巧妙","清晰","恐怖","畏怯","出纳","致意","幽灵","项","溪谷","遗传学","雄辩","约束","诱饵","建筑","奔泻","私语","任性","图案","盘旋"};
		for(int x=0;x<strs.length-1;x++){
			String fileName = "C:\\Users\\Administrator.PC-201806181513\\Downloads\\";
			fileName = fileName+"translate_tts ("+(x+1)+").mp3";
			File file = null;
			file = new File(fileName);
			if(!file.exists()){
				fileName = "C:\\Users\\Administrator.PC-201806181513\\Downloads\\translate_tts"+(x+1)+".mp3";
				file = new File(fileName);
			}
			FileInputStream fi = new FileInputStream(file);
			//lbpc_1602_audio_google_
			String s = (x+2)+"";
			if(x+2>=107){
				s = (x+3)+"";
			}
			String newFile = "C:\\Users\\Administrator.PC-201806181513\\Desktop\\audio\\lbpc_1602_audio_google_"+s+".mp3";
			FileOutputStream fo = new FileOutputStream(newFile);
			byte bf[] = new byte[1024];
			int len = 0;
			while((len = fi.read(bf))>0){
				fo.write(bf, 0, len);
			}
			fi.close();
			fo.close();
		}
		
	}
}
