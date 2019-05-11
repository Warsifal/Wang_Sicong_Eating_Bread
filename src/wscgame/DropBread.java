package wscgame;

import java.awt.event.MouseEvent;
import java.util.Random;

public class DropBread extends Movable implements Bread {
    private Random rand = new Random();
    private int speed; //= rand.nextInt(2) + 4; //移动的速度

    /**
     * 构造方法
     */
    public DropBread() {
        image = EatBread.imgBread; //图片
        width = image.getWidth();   //宽
        height = image.getHeight(); //高
        x = rand.nextInt(EatBread.WIDTH - width); //x:0到(窗口宽-面包宽)之间的随机数
        y = -height; //y:负的高
    }

    /**
     * 重写getScore()得分
     */
    public int getScore() {
        return 5; //得5分
    }

    /**
     * 重写step()走步
     */
    public void step() {
        //Gravity
        int initialSpeed = rand.nextInt(3);
        int h = y + height;
        speed = (int) (Math.sqrt(h) * 0.2 + initialSpeed);
        //
        y += speed; //y+(向下)
    }

    public void moveTo(int x) {
        float direct = x-this.x;

        if (direct < 10) {
            this.x -= 0.01*this.y;
        }
        if (direct > 20) {
            this.x += 0.01*this.y;
        }

        //System.out.println("this.x: "+this.x+" x: "+x+" direct: "+direct);

    }

    /**
     * 重写outOfBounds()检查是否越界
     */
    public boolean outOfBounds() {
        return this.y >= EatBread.HEIGHT; //y>=窗口的高，即为越界了
    }
}

