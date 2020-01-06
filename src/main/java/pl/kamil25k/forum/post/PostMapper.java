package pl.kamil25k.forum.post;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public PostMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PostDto mapToDto(Post post) {
        return modelMapper.map(post, PostDto.class);
    }

    public Post mapToEntity(PostDto postDto) {
        return modelMapper.map(postDto, Post.class);
    }

}
