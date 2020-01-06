package pl.kamil25k.forum.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamil25k.forum.user.User;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;


    @Autowired
    public PostService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public void savePost(PostDto postDto, User user) throws ParseException {
        postDto.setCreateDate(LocalDateTime.now());
        Post post = postMapper.mapToEntity(postDto);
        post.setUser(user);
        postRepository.save(post);
    }

    public Optional<PostDto> getPostById(Long id) {
        return postRepository.findById(id)
                .map(postMapper::mapToDto);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public Collection<PostDto> getAllPost() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
