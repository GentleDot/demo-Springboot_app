@Controller
@RequestMapping("/")
class ReadingListController{
    String reader = "craig"

    @Autowired
    ReadingListRepository readingListRepository // readingListRepository 주입

    @RequestMapping(method = RequestMethod.GET)
    def readersBooks(Model model){
        List<Book> readingList = readingListRepository.findByReader(reader) // 독서 목록 조회

        if (readingList){
            model.addAttribute("books", readingList) // 모델에 추가
        }
        "readingList"
    }

    @RequestMapping(method=RequestMethod.POST)
    def addToReadingList(Book book){
        book.setReader(reader)
        readingListRepository.save(book) // 책 저장

        "redirect:/" // POST 후 redirect
    }
}