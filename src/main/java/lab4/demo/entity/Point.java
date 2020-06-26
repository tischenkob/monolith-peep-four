package lab4.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "se.points")
public class Point {
    private @Id @GeneratedValue Long id;
    private Double x;
    private Double y;
    private Double r;
    private Boolean hit;

    private String username;

    public Point() {}

    public Point(double x, double y, double r, boolean hit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
    }

}