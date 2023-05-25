package com.demo.service;

import com.demo.beans.ContentBean;
import com.demo.beans.LoginUserBean;
import com.demo.beans.PageBean;
import com.demo.mapper.BoardMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

    @Value("${path.upload}")
    private String path_upload;

    @Value("${page.listcnt}")
    private int page_listcnt;

    @Value("${page.paginationcnt}")
    private int page_paginationcnt;



//    @Autowired
    private final BoardMapper boardMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Resource(name = "loginUserBean")
    private LoginUserBean loginUserBean;


    //서버로 업로드 된 파일을 업로드 폴더에 저장하고 파일의 이름을 리턴하는 메소드
    private String saveUploadFile(MultipartFile upload_file) {

        //현재 시간(밀리세컨드)을 이용해서 파일의 이름이 중복되지 않게 설정
//        String file_name = System.currentTimeMillis() + "_" + upload_file.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String file_name = uuid.toString() + "_" + upload_file.getOriginalFilename();

        try {
            upload_file.transferTo(new File(path_upload + "/" + file_name));
        }catch(Exception e) {
            e.printStackTrace();
        }

        return file_name;
    }

    // 게시글 작성
    public void addContentInfo(ContentBean writeContentBean) {

        MultipartFile upload_file = writeContentBean.getUpload_file();

        if(upload_file.getSize() > 0) {
            String file_name = saveUploadFile(upload_file);
            writeContentBean.setContent_file(file_name);
        }

        writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx());
        for (int i = 0; i < 100; i++) {
            boardMapper.addContentInfo(writeContentBean);

        }

    }

    // 제목들고오기
    public String getBoardInfoName(int board_info_idx) {
        return boardMapper.getBoardInfoName(board_info_idx);
    }

    // 게시판별 게시글목록 보기
    public List<ContentBean> getContentList(int board_info_idx, int page){

        //시작인덱스 = ( 페이지번호 - 1 ) * 10
        int start = (page-1)*page_listcnt;

        //마이바티스의 RowBounds 클래스를 사용해 가져올 글시작 번호 , 가져올갯수 로 설정
        //RowBounds 는 소량의 데이터에서 필요한 구간을 가져올 경우 엄청나게 효율적이라고 판단된다.
        //소스도 깔끔하니 보기 좋다.
        //하지만 건너띄어야 할 데이터를 모두 가져온다는 함정이 있다.
        //이는 건너띄어야 할 데이터가 많으면 많을수록 불리하다. -> 100번째 데이터 들고올때 90번째까지는 조회하고 91~100번째 데이터를 들고옴.
        //RowBounds row = new RowBounds(offset , limit);
        RowBounds rowBounds = new RowBounds(start, page_listcnt);
        //매퍼에서 처리하도록 rowBounds 객체를 매개변수로 추가



        return boardMapper.getContentList(board_info_idx, rowBounds);
    }

    public PageBean getContentCnt(int content_board_idx, int currentPage) {

        int content_cnt = boardMapper.getContentCnt(content_board_idx);

        PageBean pageBean = new PageBean(content_cnt, currentPage, page_listcnt, page_paginationcnt);

        return pageBean;
    }





    // 상세 게시글 보기
    public ContentBean getContentInfo(int content_idx) {
        return boardMapper.getContentInfo(content_idx);
    }


    //글 인덱스 번호로 검색해서 글 정보를 modifyContentBean 입력한다.
    public void getContents(ContentBean modifyContentBean) {

        ContentBean temp = boardMapper.getContentInfo(modifyContentBean.getContent_idx());
        // 수정 가능한 목록
        modifyContentBean.setContent_writer_name(temp.getContent_writer_name());
        modifyContentBean.setContent_date(temp.getContent_date());
        modifyContentBean.setContent_subject(temp.getContent_subject());
        modifyContentBean.setContent_text(temp.getContent_text());
        modifyContentBean.setContent_file(temp.getContent_file());
    }

    public void modifyContentInfo(ContentBean modifyContentBean) {

        MultipartFile upload_file = modifyContentBean.getUpload_file();

        if(upload_file.getSize() > 0) {
            String file_name = saveUploadFile(upload_file);
            modifyContentBean.setContent_file(file_name);
        }

        boardMapper.modifyContentInfo(modifyContentBean);
    }


    public void deleteContentInfo(int content_idx) {
        boardMapper.deleteContentInfo(content_idx);
    }




}
