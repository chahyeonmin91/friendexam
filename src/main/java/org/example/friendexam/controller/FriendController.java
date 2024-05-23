package org.example.friendexam.controller;

import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.example.friendexam.domain.Friend;
import org.example.friendexam.service.FriendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Iterator;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friends")

public class FriendController {
    private final FriendService friendService;

    @GetMapping
    public String friends(Model model) {
        Iterable<Friend> friends = friendService.findAllFriends();
        model.addAttribute("friends", friends);
        return "friends/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "friends/form";
    }

    @PostMapping("/add")
    public String addFriend(@ModelAttribute Friend friend, RedirectAttributes redirectAttributes) {
        friendService.saveFriend(friend);
        redirectAttributes.addFlashAttribute("message", "Friend added successfully");
        return "redirect:/friends";
    }

}
