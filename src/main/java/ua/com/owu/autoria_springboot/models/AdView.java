/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ua.com.owu.autoria_springboot.models;

import jakarta.persistence.*;
import java.time.*;
import lombok.*;

/**
 *
 * @author HP
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdView {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   @ManyToOne
    @JoinColumn(name = "ad_id")
    private Ad ad;
    
   private LocalDateTime viewedAt;
   
 
}
