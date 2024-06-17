package com.shop.ShopProject.service;

import com.shop.ShopProject.dto.ItemFormDto;
import com.shop.ShopProject.entity.Item;
import com.shop.ShopProject.entity.ItemImg;
import com.shop.ShopProject.repository.ItemImgRepository;
import com.shop.ShopProject.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemImgService itemImgService;
    private final ItemImgRepository itemImgRepository;

    public Long saveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws Exception{
        // 상품등록
        Item item = itemFormDto.createItem();
        itemRepository.save(item);

        // 이미지 등록
        for(int i=0; i<itemImgFileList.size(); i++){
            ItemImg itemImg = new ItemImg();
            itemImg.setItem(item);
            if(i == 0)
                itemImg.setRegImgYn("Y");
            else
                itemImg.setRegImgYn("N");

            itemImgService.saveItemImg(itemImg, itemImgFileList.get(i));
        }

        return item.getId();
    }
}
