package com.cavss.realestatemanager.util.checklist

import com.cavss.realestatemanager.model.CheckListModel

object CheckListData {
    val CHECKLIST_JEONSE : List<CheckListModel> = listOf(
            CheckListModel(
                type = listOf("전세", "월세", "단기임대"),
                target = listOf("깡통주택", "사회초년생","신혼부부"),
                trick = listOf("갭투자 사기"),
                doubtSituation = listOf(
                    "집주인이 전세보다 낮거나 비슷하게 매매하는 경우(대출이 끼어있는 주택을 그대로 인수하는 조건)",
                    "깡통주택. (대출금 + 보증금 총합 > 매매가)"
                ),
                relativeLaw = listOf("주택임대차보호법상 대항력의 요건\n" +
                        "주택인도(이사) + 전입신고 (이사를 한 후에 전입신고를 해야함) + 확정일자 (우선변제 권한)\n" +
                        " - 전입신고의 효력은 익일 오전 00시 00분 부터 발생한다(대항력 기준 시점)00"),
                check = "등기부 확인 하셨나요?",
                images = listOf("image1","image2","image3","image4","5","6","7")
            ),
            CheckListModel(
                type = listOf("전세"),
                target = listOf("깡통주택", "사회초년생","신혼부부"),
                trick = listOf("갭투자 사기"),
                doubtSituation = listOf(
                    "계약일로부터 잔금 및 입주일자 익일까지 현재 상태의 등기부등본을 유지해야 하며 근저당 외 다른 대출 설정은 하지 않는다. " +
                            "이를 위반할 때에는 임차인은 계약해지를 요구할 수 있고 임대인은 계약금의 배액을 임차인에게 지불한다.",
                    "위의 특약이 없을 경우, 주택임댕차보호법상 대항력의 요건이 갖추어지기 전에 사기를 당할 수 있습니다."
                ),
                relativeLaw = listOf("주택임대차보호법상 대항력의 요건\n" +
                        "주택인도(이사) + 전입신고 (이사를 한 후에 전입신고를 해야함) + 확정일자 (우선변제 권한)\n" +
                        " - 전입신고의 효력은 익일 오전 00시 00분 부터 발생한다(대항력 기준 시점)00"),
                check = "특약이 걸려있나요?",
                images = listOf("","","","","","","")
            ),
            CheckListModel(
                type = listOf("전세", "월세", "단기임대"),
                target = listOf("전입신고", "근저당","무 대항력"),
                trick = listOf("전입신고의 허점"),
                doubtSituation = listOf(
                    "전입신고 한 날 '근저당'이 설정됨",
                    "집주인이 전,월세 계약 후 전입신고의 효력이 발생하기 전에 대출 또는 매도하는 경우(세입자 입장에서는 대항력이 가주어지기 전이라 법적으로 보호받기 어려움)"
                ),
                relativeLaw = listOf("법1", "법2"),
                check = "주택임대차보호법상 대항력,  우선변제권을 바로 구비하셨나요?",
                images = listOf("","","","","","","")
            ),
            CheckListModel(
                type = listOf("전세", "월세", "단기임대"),
                target = listOf("타겟1", "타겟2"),
                trick = listOf("전입신고의 허점"),
                doubtSituation = listOf(
                    "등기부에 '수탁자 xx신탁회사' ",
                    "깨끗한 신축빌라에 전액대출이 가능한 꿀같은 집"
                ),
                relativeLaw = listOf("제 3자와의 관계에서 수탁자(신탁회사)가 소유권자가 되며, 집주인은 무권한자에 불과함."),
                check = "등기부에 '수탁자 xx신탁회사' 라고 기재되어있나요?",
                images = listOf("","","","","","","")
            ),
            CheckListModel(
                type = listOf("전세"),
                target = listOf("타겟1", "타겟2"),
                trick = listOf("전입신고의 허점"),
                doubtSituation = listOf(
                    "전세 만료 기간이 다가오자 잠적한 집주인은 외국인 또는 이종국자라 잡기가 굉장히 힘들다.",
                    ""
                ),
                relativeLaw = listOf("법1", "법2"),
                check = "집주인이 혹시 외국인 또는 이중국적자이거나 등기부등본상 해외에 거주하고 있나요?",
                images = listOf("","","","","","","")
            ),
            CheckListModel(
                type = listOf("전세"),
                target = listOf("타겟1", "타겟2"),
                trick = listOf("전입신고의 허점"),
                doubtSituation = listOf("",""),
                relativeLaw = listOf("법1", "법2"),
                check = "주택도시보증공사의 전세보증금반환보증에 가입하셨나요?",
                images = listOf("","","","","","","")
            ),
            CheckListModel(
                type = listOf("전세"),
                target = listOf("타겟1", "타겟2"),
                trick = listOf("전입신고의 허점"),
                doubtSituation = listOf("",""),
                relativeLaw = listOf("법1", "법2"),
                check = "주택인도(이사) + 전입신고 + 확정일자를 바로 받으셨나요?",
                images = listOf("","","","","","","")
            )
        )
    val CHECKLIST_MONTHLYRENT : List<CheckListModel> = listOf(

    )
    val CHECKLIST_BUY : List<CheckListModel> = listOf()
}