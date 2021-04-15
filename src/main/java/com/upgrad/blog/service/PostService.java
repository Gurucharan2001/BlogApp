package com.upgrad.blog.service;

import com.upgrad.blog.model.Post;
import com.upgrad.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    //getAllPosts,getPost,deletePost,updatePost,addPost

    public List<Post> getAllPosts(){
        return (List<Post>) this.postRepository.findAll();
    }

    public Post getPost(Integer id){
        Optional<Post> post = this.postRepository.findById(id);
        if(post.isPresent()){
            return post.get();
        }else{
            return null;
        }
    }

    public void deletePost(Integer id){
        this.postRepository.deleteById(id);
    }

    public void addPost(Post post){
        this.postRepository.save(post);
    }

    public boolean updatePost(Integer id ,Post post){
        //check the id
        //if it exists then update else do nothing
        /*
        Optional<Post> findPost = this.postRepository.findById(id);
        if(findPost.isPresent()){
            this.postRepository.save(findPost.get());
        }else{
            System.out.println("***DO NOTHING***");
        }*/
        if(this.postRepository.existsById(id)){
            this.postRepository.save(post);
            return true;
        }
        else{
            return false;
        }

    }



}
