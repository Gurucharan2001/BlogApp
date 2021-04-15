package com.upgrad.blog.controller;

import com.upgrad.blog.model.Post;
import com.upgrad.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET,value = "/posts")
    public List<Post> getAllPosts(){
        return this.postService.getAllPosts();
    }

    @RequestMapping("/posts/{id}")
    public Post getPost(@PathVariable Integer id){
        return this.postService.getPost(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/posts")
    public String addPost(@RequestBody Post post){
        System.out.println(post.getTitle());
        post.setDate(new Date());
        postService.addPost(post);
        String response = "{\"success\":true,\"message\":\"Post has been added successfully.\"}";
        return response;
    }

    @DeleteMapping("/posts/id")
    public String deletePost(@PathVariable Integer id){
        this.postService.deletePost(id);
        String response = "{\"success\":true,\"message\":\"Post has been deleted successfully.\"}";
        return response;
    }

}
