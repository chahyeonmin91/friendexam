package org.example.friendexam.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Friend {
    private Long id;
    private String name;
    private String email;
}