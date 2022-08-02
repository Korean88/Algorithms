class ListNode:
    def __init__(self, value, next):
        self.value = value
        self.next = next

    def __eq__(self, o: object) -> bool:
        this = self
        if o.__class__ != ListNode:
            return False
        while this is not None:
            if o is None:
                return False
            if o.value != this.value:
                return False
            this = this.next
            o = o.next
        return True



