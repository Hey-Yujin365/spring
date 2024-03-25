package com.example.common;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Component;

@Component
public class Markdown {

	/**
	 * 마크다운 형식의 텍스트를 HTML 태그로 변환해서 반환한다.
	 * @param markdownText 마크다운 형식의 텍스트
	 * @return html 콘텐츠
	 */
	public String render(String markdownText) {
		Parser parser = Parser.builder().build();
		Node document = parser.parse(markdownText);
		HtmlRenderer renderer = HtmlRenderer.builder().build();
		return renderer.render(document);
				
	}
}
