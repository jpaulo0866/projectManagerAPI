package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import com.viaflow.manager.api.entity.comment.Comment;

@Component
public class CommentValidation implements BaseValidation<Comment> {
	
	
	@Override
	public boolean validateObject(Comment object, BindingResult result) {
		if (object.getProject() == null) {
			result.addError(new ObjectError("Comment", "Field Project should be informed"));
		}
		if(object.getUser() == null) {
			result.addError(new ObjectError("Comment", "Field User should be informed"));
		}
		if(object.getComment() == null || object.getComment().isEmpty()) {
			result.addError(new ObjectError("Comment", "Field Comment should be informed"));
		}
		return !result.hasErrors();
	}
}
